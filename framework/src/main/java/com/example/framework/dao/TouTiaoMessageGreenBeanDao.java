package com.example.framework.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TOU_TIAO_MESSAGE_GREEN_BEAN".
*/
public class TouTiaoMessageGreenBeanDao extends AbstractDao<TouTiaoMessageGreenBean, Long> {

    public static final String TABLENAME = "TOU_TIAO_MESSAGE_GREEN_BEAN";

    /**
     * Properties of entity TouTiaoMessageGreenBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Tilte = new Property(1, String.class, "tilte", false, "TILTE");
        public final static Property IsShow = new Property(2, boolean.class, "isShow", false, "IS_SHOW");
        public final static Property Tag = new Property(3, String.class, "tag", false, "TAG");
    }


    public TouTiaoMessageGreenBeanDao(DaoConfig config) {
        super(config);
    }
    
    public TouTiaoMessageGreenBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TOU_TIAO_MESSAGE_GREEN_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TILTE\" TEXT," + // 1: tilte
                "\"IS_SHOW\" INTEGER NOT NULL ," + // 2: isShow
                "\"TAG\" TEXT);"); // 3: tag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TOU_TIAO_MESSAGE_GREEN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TouTiaoMessageGreenBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String tilte = entity.getTilte();
        if (tilte != null) {
            stmt.bindString(2, tilte);
        }
        stmt.bindLong(3, entity.getIsShow() ? 1L: 0L);
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(4, tag);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TouTiaoMessageGreenBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String tilte = entity.getTilte();
        if (tilte != null) {
            stmt.bindString(2, tilte);
        }
        stmt.bindLong(3, entity.getIsShow() ? 1L: 0L);
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(4, tag);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TouTiaoMessageGreenBean readEntity(Cursor cursor, int offset) {
        TouTiaoMessageGreenBean entity = new TouTiaoMessageGreenBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tilte
            cursor.getShort(offset + 2) != 0, // isShow
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // tag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TouTiaoMessageGreenBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTilte(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsShow(cursor.getShort(offset + 2) != 0);
        entity.setTag(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TouTiaoMessageGreenBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TouTiaoMessageGreenBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TouTiaoMessageGreenBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
