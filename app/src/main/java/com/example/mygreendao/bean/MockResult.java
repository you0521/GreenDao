package com.example.mygreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author：  jcy
 * data：2020/5/28
 * time：10:25
 * description：
 */

@Entity
public class MockResult {
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int gradle;
    @Generated(hash = 1187593283)
    public MockResult(Long id, @NotNull String name, int gradle) {
        this.id = id;
        this.name = name;
        this.gradle = gradle;
    }
    @Generated(hash = 1309768796)
    public MockResult() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGradle() {
        return this.gradle;
    }
    public void setGradle(int gradle) {
        this.gradle = gradle;
    }

}
