package com.test.service.impl;

import com.test.dao.AreaDao;
import com.test.domain.dto.AreaDTO;
import com.test.domain.orm.Area;
import com.test.service.IAreaService;
import com.test.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by brander on 2018/3/1
 */
@Service
public class AreaServiceImpl implements IAreaService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaDao areaDao;

    /**
     * 获取区域列表
     *
     * @return 列表
     */
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }


    /**
     * 获取区域数量
     *
     * @return 区域数量
     */
    @Override
    public int getCount() {
        return areaDao.getCount();
    }

    /**
     * 根据id获取区域数据
     *
     * @param areaId 区域id
     * @return 区域信息
     */
    @Override
    public Area getAreaById(int areaId) {


        return areaDao.queryAreaById(areaId);
    }

    /**
     * 增加区域
     *
     * @param area 区域
     * @return 是否成功
     */
    @Override
    public boolean addArea(AreaDTO area) {
        if (StringUtils.isEmpty(area.getAreaName())) {
            return false;
        }
        int effectNum = areaDao.insertArea(area);
        return effectNum > 0;
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() == null || area.getAreaId() <= 0) {
            return false;
        }
        int effectNum = areaDao.updateArea(area);
        return effectNum > 0;
    }

    @Override
    public boolean deleteAreaById(int areaId) {
        if (areaId > 0) {
            return false;
        }
        int effectNum = areaDao.deleteArea(areaId);
        return effectNum > 0;

    }


}
