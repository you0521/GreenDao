package com.example.mygreendao;

import android.content.Context;

import com.example.mygreendao.bean.DaoSession;
import com.example.mygreendao.bean.MockResult;
import com.example.mygreendao.bean.MockResultDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * author：  jcy
 * data：2020/5/28
 * time：10:31
 * description：
 */
public class StudentDaoUtil {
    private static final boolean DUBUG = true;
    private DaoManager manager;
    private MockResultDao studentDao;
    private DaoSession daoSession;

    public StudentDaoUtil(Context context) {
        manager = DaoManager.getInstance();
        manager.init(context);
        daoSession = manager.getDaoSession();
        manager.setDebug(DUBUG);
    }

    /**
     * 添加数据，如果有重复则覆盖
     */
    public void insertStudent(MockResult student) {
        manager.getDaoSession().insertOrReplace(student);
    }

    /**
     * 添加多条数据，需要开辟新的线程
     */
    public void insertMultStudent(final List<MockResult> students) {
        manager.getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (MockResult student : students) {
                    manager.getDaoSession().insertOrReplace(student);
                }
            }
        });
    }


    /**
     * 删除数据
     */
    public void deleteStudent(MockResult student) {
        manager.getDaoSession().delete(student);
    }

    /**
     * 删除全部数据
     */
    public void deleteAll(Class cls) {
        manager.getDaoSession().deleteAll(cls);
    }

    /**
     * 更新数据
     */
    public void updateStudent(MockResult student) {
        manager.getDaoSession().update(student);
    }

    /**
     * 按照主键返回单条数据
     */
    public MockResult listOneStudent(long key) {
        return manager.getDaoSession().load(MockResult.class, key);
    }

    /**
     * 根据指定条件查询数据
     */
    public List<MockResult> queryStudent() {
        //查询构建器
        QueryBuilder<MockResult> builder = manager.getDaoSession().queryBuilder(MockResult.class);
        List<MockResult> list = builder.where(MockResultDao.Properties.Gradle.ge(1)).where(MockResultDao.Properties.Name.like("王小二")).list();
        return list;
    }

    /**
     * 查询全部数据
     */
    public List<MockResult> queryAll() {
        return manager.getDaoSession().loadAll(MockResult.class);
    }
}
