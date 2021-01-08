package com.song.fromwork.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEWS_CHANNEL_BEAN".
*/
public class NewsChannelBeanDao extends AbstractDao<NewsChannelBean, Void> {

    public static final String TABLENAME = "NEWS_CHANNEL_BEAN";

    /**
     * Properties of entity NewsChannelBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ChannelId = new Property(0, String.class, "channelId", false, "CHANNEL_ID");
        public final static Property ChannelName = new Property(1, String.class, "channelName", false, "CHANNEL_NAME");
        public final static Property IsEnable = new Property(2, int.class, "isEnable", false, "IS_ENABLE");
        public final static Property Position = new Property(3, int.class, "position", false, "POSITION");
    }


    public NewsChannelBeanDao(DaoConfig config) {
        super(config);
    }
    
    public NewsChannelBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEWS_CHANNEL_BEAN\" (" + //
                "\"CHANNEL_ID\" TEXT," + // 0: channelId
                "\"CHANNEL_NAME\" TEXT," + // 1: channelName
                "\"IS_ENABLE\" INTEGER NOT NULL ," + // 2: isEnable
                "\"POSITION\" INTEGER NOT NULL );"); // 3: position
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEWS_CHANNEL_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, NewsChannelBean entity) {
        stmt.clearBindings();
 
        String channelId = entity.getChannelId();
        if (channelId != null) {
            stmt.bindString(1, channelId);
        }
 
        String channelName = entity.getChannelName();
        if (channelName != null) {
            stmt.bindString(2, channelName);
        }
        stmt.bindLong(3, entity.getIsEnable());
        stmt.bindLong(4, entity.getPosition());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, NewsChannelBean entity) {
        stmt.clearBindings();
 
        String channelId = entity.getChannelId();
        if (channelId != null) {
            stmt.bindString(1, channelId);
        }
 
        String channelName = entity.getChannelName();
        if (channelName != null) {
            stmt.bindString(2, channelName);
        }
        stmt.bindLong(3, entity.getIsEnable());
        stmt.bindLong(4, entity.getPosition());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public NewsChannelBean readEntity(Cursor cursor, int offset) {
        NewsChannelBean entity = new NewsChannelBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // channelId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // channelName
            cursor.getInt(offset + 2), // isEnable
            cursor.getInt(offset + 3) // position
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, NewsChannelBean entity, int offset) {
        entity.setChannelId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setChannelName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsEnable(cursor.getInt(offset + 2));
        entity.setPosition(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(NewsChannelBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(NewsChannelBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(NewsChannelBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
