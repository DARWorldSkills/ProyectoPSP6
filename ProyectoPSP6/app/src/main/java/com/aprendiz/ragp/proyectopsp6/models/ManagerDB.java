package com.aprendiz.ragp.proyectopsp6.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManagerDB {
    GestorDB gestorDB;
    SQLiteDatabase db;
    Context context;

    public ManagerDB(Context context) {
        this.context = context;
    }

    public void openRead(){
        gestorDB = new GestorDB(context);
        db=gestorDB.getReadableDatabase();
    }


    public void openWrite(){
        gestorDB = new GestorDB(context);
        db=gestorDB.getWritableDatabase();
    }


    public List<Project> projectList(){
        List<Project> results =new ArrayList<>();
        openRead();
        Cursor cursor = db.rawQuery("SELECT * FROM PROJECT;",null);
        if (cursor.moveToFirst()){
            do {
                Project project= new Project();
                project.setId(cursor.getInt(0));
                project.setName(cursor.getString(1));
                results.add(project);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }

    public void inputProject(Project project){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("NAME",project.getName());
        db.insert("PROJECT",null,values);
        closeDB();

    }


    public List<CTimeLog> timeLogList(int projecj){
        List<CTimeLog> results =new ArrayList<>();
        openRead();
        Cursor cursor = db.rawQuery("SELECT * FROM TIMELOG WHERE PROJECT="+projecj+";",null);
        if (cursor.moveToFirst()){
            do {
                CTimeLog cTimeLog = new CTimeLog();
                cTimeLog.setId(cursor.getInt(0));
                cTimeLog.setPhase(cursor.getString(1));
                cTimeLog.setStart(cursor.getString(2));
                cTimeLog.setInterrupcions(cursor.getInt(3));
                cTimeLog.setStop(cursor.getString(4));
                cTimeLog.setDelta(cursor.getInt(5));
                cTimeLog.setComments(cursor.getString(6));
                cTimeLog.setProject(cursor.getInt(7));
                results.add(cTimeLog);

            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();


        return results;
    }

    public void inputTimeLog(CTimeLog cTimeLog){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("PHASE",cTimeLog.getPhase());
        values.put("START",cTimeLog.getStart());
        values.put("INTERRUPCION", cTimeLog.getInterrupcions());
        values.put("STOP",cTimeLog.getStop());
        values.put("DELTA",cTimeLog.getDelta());
        values.put("COMMENTS",cTimeLog.getComments());
        values.put("PROJECT",cTimeLog.getProject());
        db.insert("TIMELOG",null,values);
        closeDB();
    }

    public void updateTimeLog(CTimeLog cTimeLog){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("PHASE",cTimeLog.getPhase());
        values.put("START",cTimeLog.getStart());
        values.put("INTERRUPCION", cTimeLog.getInterrupcions());
        values.put("STOP",cTimeLog.getStop());
        values.put("DELTA",cTimeLog.getDelta());
        values.put("COMMENTS",cTimeLog.getComments());
        String [] parameters = {Integer.toString(cTimeLog.getId())};
        db.update("TIMELOG",values,"IDTIMELOG=?",parameters);
        closeDB();
    }

    public void delteTimeLog(CTimeLog cTimeLog){
        openWrite();
        ContentValues values = new ContentValues();
        String [] parameters = {Integer.toString(cTimeLog.getId())};
        db.delete("TIMELOG","IDTIMELOG=?",parameters);
        closeDB();
    }

    public List<CDefectLog> defectLogList(int projecj){
        List<CDefectLog> results =new ArrayList<>();
        openRead();
        Cursor cursor = db.rawQuery("SELECT * FROM DEFECTLOG WHERE PROJECT="+projecj+";",null);
        if (cursor.moveToFirst()){
            do {
                CDefectLog cDefectLog = new CDefectLog();
                cDefectLog.setId(cursor.getInt(0));
                cDefectLog.setDate(cursor.getString(1));
                cDefectLog.setType(cursor.getString(2));
                cDefectLog.setFixtime(cursor.getString(3));
                cDefectLog.setPhaseI(cursor.getString(4));
                cDefectLog.setPhaseR(cursor.getString(5));
                cDefectLog.setComments(cursor.getString(6));
                cDefectLog.setProject(cursor.getInt(7));
                results.add(cDefectLog);

            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();


        return results;
    }


    public void inputDefectLog(CDefectLog cDefectLog){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("DATE",cDefectLog.getDate());
        values.put("TYPE",cDefectLog.getType());
        values.put("FIXTIME", cDefectLog.getFixtime());
        values.put("PHASEI",cDefectLog.getPhaseI());
        values.put("PHASER",cDefectLog.getPhaseR());
        values.put("COMMENTS",cDefectLog.getComments());
        values.put("PROJECT",cDefectLog.getProject());
        db.insert("DEFECTLOG",null,values);
        closeDB();
    }

    public void updateDefectLog(CDefectLog cDefectLog){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("DATE",cDefectLog.getDate());
        values.put("TYPE",cDefectLog.getType());
        values.put("FIXTIME", cDefectLog.getFixtime());
        values.put("PHASEI",cDefectLog.getPhaseI());
        values.put("PHASER",cDefectLog.getPhaseR());
        values.put("COMMENTS",cDefectLog.getComments());
        String [] parameters = {Integer.toString(cDefectLog.getId())};
        db.update("DEFECTLOG",values,"IDDEFECTLOG=?",parameters);
        closeDB();
    }

    public void deleteDefectLog(CDefectLog cDefectLog){
        openWrite();
        ContentValues values = new ContentValues();
        String [] parameters = {Integer.toString(cDefectLog.getId())};
        db.delete("DEFECTLOG","IDDEFECTLOG=?",parameters);
        closeDB();
    }


    public List<CPPS> ppsList(int projecj){
        List<CPPS> results =new ArrayList<>();
        openRead();
        Cursor cursor = db.rawQuery("SELECT * FROM PPS WHERE PROJECT="+projecj+";",null);
        if (cursor.moveToFirst()){
            do {
                CPPS cpps= new CPPS();
                cpps.setId(cursor.getInt(0));
                cpps.setTime(cursor.getInt(1));
                cpps.setProject(cursor.getInt(2));
                results.add(cpps);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }

    public void inputPPS(CPPS cpps){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("TIME",cpps.getTime());
        values.put("PROJECT",cpps.getProject());
        db.insert("PPS",null,values);
        closeDB();
    }

    public void updatePPS(CPPS cpps){
        openWrite();
        ContentValues values = new ContentValues();
        values.put("TIME",cpps.getTime());
        String [] parameters = {Integer.toString(cpps.getId())};
        db.update("PPS",values,"IDPPS=?",parameters);
        closeDB();
    }




    public void closeDB(){
        db.close();
    }


}
