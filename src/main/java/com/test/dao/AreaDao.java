package com.test.dao;


import com.test.domain.dto.AreaDTO;
import com.test.domain.orm.Area;

import java.util.List;

/**
 * @author wangban
 * @date 10:21 2019/3/7
 */
public interface AreaDao {

    /**
     * 列出区域列表
     *
     * @return 区域列表
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域
     *
     * @param areaId id
     * @return 区域
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area 区域
     * @return 影响行
     */
    int insertArea(AreaDTO area);

    /**
     * 更新区域信息
     *
     * @param area 区域
     * @return 影响行
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId 区域id
     * @return 影响行
     */
    int deleteArea(int areaId);

    /**
     * 获取区域数量
     *
     * @return 数量
     */
    int getCount();

    /**
     * 更新区域
     *
     * @param area 区域
     * @return 影响行
     */
    int updateSelect(Area area);
}
