package com.bishe.main.vo;

import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.Technology;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/1 15:57
 */
public class TechnologeVO extends Technology {
    private String TechnologyTypeName;

    private List<TechFile> techFileList;

    public String getTechnologyTypeName() {
        return TechnologyTypeName;
    }

    public void setTechnologyTypeName(String technologyTypeName) {
        TechnologyTypeName = technologyTypeName;
    }

    public List<TechFile> getTechFileList() {
        return techFileList;
    }

    public void setTechFileList(List<TechFile> techFileList) {
        this.techFileList = techFileList;
    }
}
