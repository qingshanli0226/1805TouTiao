package com.song.search.dao;

public class SearchHistoryTable {


    public static final String TABLENAME = "SearchHistoryTable";


    public static final String ID = "id";
    public static final String KEYWORD = "keyWord";
    public static final String TIME = "time";

    public static final int ID_ID = 0;
    public static final int ID_KEYWORD = 1;
    public static final int ID_TIME = 2;

    public static final String CREATE_TABLE = "create table if not exists " + TABLENAME + "(" +
            ID + " text auto_increment, " +
            KEYWORD + " text primary key, " +
            TIME + " text) ";
}
