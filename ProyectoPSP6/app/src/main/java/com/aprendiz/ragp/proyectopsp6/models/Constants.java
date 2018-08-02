package com.aprendiz.ragp.proyectopsp6.models;

public class Constants {
    public static final String DATABASE_NAME="psp.db";
    public static final int DATABASE_VERSION=1;


    public static final String TableProject="CREATE TABLE PROJECT (IDPROJECT INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT);";
    public static final String TableTimeLog="CREATE TABLE TIMELOG (IDTIMELOG INTEGER PRIMARY KEY AUTOINCREMENT, PHASE TEXT, START TEXT, INTERRUPCION INTEGER ,STOP TEXT, DELTA INTEGER, COMMENTS TEXT, PROJECT INTEGER,)"

}
