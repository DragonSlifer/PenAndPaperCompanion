package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

/**
 * Created by Jorge on 26/11/2017.
 */

public class Constants {
    ///< Class Constants
    public final static String ClassABFCharacter            = "class_abf_character";
    public final static String DatabaseConnectorClass       = "DatabaseConnectorClass";
    public final static String UserClass                    = "UserClass";
    ///< Database Collection/Document Constants
    public final static String CollectionUserData           = "UserData";
    public final static String CollectionABF                = "AnimaBeyondFantasy";
    public final static String CollectionABFCharacterSheets     = "CharacterSheets";
    public final static String CollectionABFUserSheets              = "?_sheets";       ///< Exchange the '?' with the user unique key
    public final static String CollectionABFGeneralInfo         = "GeneralInfo";
    public final static String CollectionABFClassRelated            = "ClassRelated";
    public final static String CollectionABFDocGeneralCosts             = "GeneralInfo";
    public final static String CollectionABFDocCategories               = "Categories";
    public final static String CollectionABFAbilities                   = "Abilities";
    public final static String CollectionABFGaia                    = "Gaia";
    public final static String CollectionABFMonsters                    = "Monsters";
    public final static String CollectionABFNaturals                        = "Naturals";
    public final static String CollectionABFBetweenWorlds                   = "BetweenWorlds";
    public final static String CollectionABFBetweenWorldsElementals         = "BetweenWorldsElementals";
    public final static String CollectionABFAnima                           = "Anima";
    public final static String CollectionABFAnimaElementals                 = "AnimaElementals";
    public final static String CollectionABFUndead                          = "Undead";
    public final static String CollectionABFGeography                   = "Geography";
    public final static String CollectionABFEthnics                     = "Ethnics";
    public final static String CollectionABFRaces                       = "Races";
    public final static String CollectionABFTables              = "Tables";
    public final static String CollectionABFUserEdits           = "UserEdits";
    public final static String CollectionABFUserEditsPersonal      = "?_edits";
    ///< Activity result codes
    //001
    public final static int RESULT_OK = 1;
    //001-050 (Internal Result Codes)
    //051-099
    //100-150
    //151-199
    //200-250 (External Result Codes)
    public final static int RC_SIGN_IN = 200;   ///< Authentication Result Code
    //251-299
    //300-350
    //351-399
    //400-450 (Error Result Codes)
    //451-499
    ///< Extra Intent Parameter Identifiers Constants
    public final static String ForWritting                  = "ForWritting";
    public final static String ObjectType                   = "ObjectType";
    public final static String Collection                   = "Collection";
    public final static String SaveDataClass                = "SaveDataClass";
    public final static String DatabaseConnector            = "DatabaseConnector";
    public final static String User                         = "User";
    ///< Tag Class
    public final static String DatabaseConnectorTAG         = "DB_CONNECTOR";
    public final static String UserTAG                      = "USER";
    ///< User identifiers
    private static String UserIdentifier;



    public static void setUserIdentifier(String userIdentifier){
        UserIdentifier = userIdentifier;
    }

    public static String getUserIdentifierCollection(String collection){
        return  collection + "_" + UserIdentifier;
    }

}
