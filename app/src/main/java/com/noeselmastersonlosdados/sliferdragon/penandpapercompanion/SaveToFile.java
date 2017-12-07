package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion;

import android.content.Intent;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SaveToFile extends AppCompatActivity {

    private String game;
    private ArrayList<file> files;
    private Object characterSheet;
    private boolean update;
    private static String filenamesFile = "filenames.bin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_file);
        files = new ArrayList<>();

        game = getIntent().getStringExtra("Game");
        //forWriting = getIntent().getStringArrayListExtra("ForWriting");
        characterSheet = getIntent().getParcelableExtra("ForWriting");

        Spinner filenames = (Spinner) findViewById(R.id.filenameSpinner);
        readFileNames();
        if (!files.isEmpty()) {
            String[] onlyFilenames = new String[files.size()];  ///< We just want the filenames

            for (int i = 0; i < files.size(); i++){
                onlyFilenames[i] = files.get(i).getFilename();
            }

            filenames.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, onlyFilenames));
        }
        update = false;
    }

    /**
     * This reads all filenames and file extensions
     */
    public void readFileNames(){
        try{
            String filename_ext;
            file file_aux = new file();

            if(checkState() == 0 || checkState() == 1){     ///< At the moment, we only need to read

                File SD_Route = Environment.getExternalStorageDirectory();
                File file = new File(SD_Route.getAbsolutePath(),filenamesFile);

                BufferedReader bread = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                while((filename_ext = bread.readLine()) != null) {
                    file_aux.setFilename(filename_ext);
                    files.add(file_aux);
                }

                bread.close();
            } else {
                Log.d("INFO", "WARNING: UNABLE TO ACCESS TO EXTERNAL MEMORY");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String writeFileNames(String filename){
        if(!update) {        ///< In the case that we aren't updating a file, we've got to set a different filename if exists a file with the same name
            int same;
            if ((same = sameName(filename)) != 0) {
                filename += "_" + Integer.toString(same);
            }
        }
        filename += getExtension(game);
        Log.d("INFO","Filename: " + filename);
        ArrayList<String> write = new ArrayList<>();
        write.add(filename);
        genericWritter(filenamesFile,write,update);   ///< If it's updating, it would add lines
        return filename;
    }

    private int sameName(String filename) {
        int same = 0;
        int i = 0;

        while(i < files.size()){
            if(files.get(i).getFilename().contains(filename)){
                same++;
            }
            i++;
        }

        return same;
    }

    /**
     * This sets a 3 word identifier for all the extensions, so the program can
     * differ from the different games and option files.
     *
     * @param filename
     * @return
     */
    private String getGame(String filename) {
        String ext = extractFilenameExtension(filename);
        String retVal;
        switch (ext){
            case ".abf":    ///< .abf files are related to Anima Beyond Fantasy
                retVal = "ABF";
                break;
            case ".vtm":    ///< .vtm files are related too Vampire the Masquerade
                retVal = "VTM";
                break;
            default:        ///< No extension files, or not recognized, are treated as normal files
                retVal = "NOGAME";
                break;
        }
        return retVal;
    }

    /**
     * This converts all word identifier to the extensions.
     *
     * @param fileext
     * @return
     */
    private String getExtension(String fileext) {
        String retVal;
        switch (fileext){
            case "ABF":    ///< .abf files are related to Anima Beyond Fantasy
                retVal = ".abf";
                break;
            case "VTM":    ///< .vtm files are related too Vampire the Masquerade
                retVal = ".vtm";
                break;
            default:        ///< No extension files, or not recognized, are treated as normal files
                retVal = "";
                break;
        }
        return retVal;
    }

    /**
     * This just writes info in a file. Simply that
     *
     * @param filename
     * @param linesToWrite
     * @param update
     */
    public void genericWritter(String filename, ArrayList<String> linesToWrite, boolean update){

        try{
            if(checkState() == 0){
                File SD_Route = Environment.getExternalStorageDirectory();
                File file = new File(SD_Route.getAbsolutePath(),filename);

                BufferedWriter bwrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,update)));  ///< If update it's true, it will append

                if (!linesToWrite.isEmpty()){
                    for (int i = 0; i < linesToWrite.size(); i++){
                        writeSingleLine(bwrite,linesToWrite.get(i));
                    }
                }

                bwrite.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Writes only one line and a new line
     * @param bwrite
     * @param s
     * @throws IOException
     */
    private void writeSingleLine(BufferedWriter bwrite, String s) throws IOException {
        bwrite.write(s + "\n");
    }

    /**
     * Checks if we can use the external storage or not.
     * -1 --> No Access
     *  0 --> Full Access
     *  1 --> Read Only
     * @return
     */
    private int checkState() {
        int sdAccess = -1;

        String state = Environment.getExternalStorageState();

        if(state.equals(Environment.MEDIA_MOUNTED)){
            sdAccess = 0;
        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            sdAccess = 1;
        }

        return sdAccess;
    }

    private String extractFilenameExtension(String filename_ext) {
        return filename_ext.substring(filename_ext.indexOf('.'));
    }

    private String extractFilename(String filename_ext) {
        return filename_ext.substring(0,filename_ext.indexOf('.')-1);
    }

    public void update(View view){
        Spinner filenameET = (Spinner) findViewById(R.id.filenameSpinner);
        this.update = true;
        writeFileNames(filenameET.getSelectedItem().toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(new File(filenameET.getSelectedItem().toString()))
            );
            oos.writeObject(characterSheet);    ///< Writes the character sheet
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNew(View view){
        String filename = characterSheet.toString();
        this.update = true;
        Log.d("INFO","Saving file name");
        filename = writeFileNames(filename);
        Log.d("INFO","Saving character sheet " + filename);
        this.update = false;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(new File(filename))
            );
            oos.writeObject(characterSheet);    ///< Writes the character sheet
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(View view){

    }

    public void load(View view){
        String filename = ((Spinner) findViewById(R.id.filenameSpinner)).getSelectedItem().toString();

        try{
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream((new File(filename)
            )));
            characterSheet = ois.readObject();  ///< Reads the character sheet
            ois.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        onBackPressed();
    }

    @Override
    public void onBackPressed(){
        Intent data = new Intent();
        data.putExtra("CharacterSheet", (Parcelable)characterSheet);
        setResult(1,data);
        finish();
    }

    private class file{
        String filename;

        public file() {
        }

        public file(String filename, String file_extension) {
            this.filename = filename;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }
    }
}
