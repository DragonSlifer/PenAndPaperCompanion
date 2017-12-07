package BESM;

import java.util.Vector;

/**
 * Created by Jorge on 04/04/2017.
 * This class will contain the BESM character info
 */

public class BESM_Char_Info {
    private int Body, Mind, Soul;           ///< Main Stats
    private Vector<Attribute> attributes;   ///< Attributes
    private Vector<Defect> defects;         ///< Defects
    /**
     * Private attribute class for BESM
     */
    private class Attribute {
        private String name;
        private int cost;
        private int level;
        private String explanation;
        /**
         * This would create an attribute with base parameters.
         * + , - , / , * , ^
         * @param name
         * @param cost
         * @param level
         */
        public Attribute (String name, int cost, int level, String explanation){
            this.name = name;
            this.cost = cost;
            this. level = level;
            this.explanation = explanation;
        }

        /**
         * Just for returning info
         * @return
         */
        public String toString (){
            return "Name("+name + ")Cost(" + cost + ")Level(" + level + ")";
        }

        public int getLevelCost(){
            return level * cost;
        }

        public void setLevel(int level){
            this.level = level;
        }

        public void setExplanation(String explanation){
            this.explanation = explanation;
        }
    }
    /**
     * Private defect class for BESM
     */
    private class Defect {

    }

    public BESM_Char_Info(){
        this.attributes = new Vector<>();
        this.defects = new Vector<>();
        this.Body = 0;
        this.Mind = 0;
        this.Soul = 0;
    }
}
