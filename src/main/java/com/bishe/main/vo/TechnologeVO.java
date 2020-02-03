package com.bishe.main.vo;

import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.Technology;
import lombok.Data;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/1 15:57
 */
@Data
public class TechnologeVO extends Technology {
    private String TechnologyTypeName;

    private List<TechFile> techFileList;
}
