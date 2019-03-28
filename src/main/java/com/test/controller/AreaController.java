package com.test.controller;

import com.test.common.result.ResultJson;
import com.test.common.result.ResultList;
import com.test.common.util.TextUtil;
import com.test.domain.dto.AreaDTO;
import com.test.domain.orm.Area;
import com.test.service.IAreaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区域api
 *
 * @author wangban
 * @date 9:56 2019/3/7
 */
@RestController
@RequestMapping("/superAdmin")
public class AreaController {

    private Logger log = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private IAreaService iAreaService;

    @ApiOperation(value = "王斑: ", notes = "")
    @GetMapping(value = "getAddress")
    public ResultJson<String> getAddress(String address) {
        return ResultJson.createBySuccess(TextUtil.base58checkToHexString(address));
    }

    @ApiOperation(value = "王斑: ", notes = "")
    @GetMapping(value = "getString")
    public ResultJson<String> getString(String msg) {
        return ResultJson.createBySuccess(TextUtil.hexStringToString(msg));
    }

    @ApiOperation(value = "王斑: 获取区域列表", notes = "")
    @GetMapping(value = "list")
    public ResultJson<ResultList<Area>> getAreaList() {
        ResultList<Area> areaResultList = new ResultList<>();

        int count = iAreaService.getCount();
        if (count <= 0) {
            return ResultJson.createBySuccess(areaResultList);
        }

        areaResultList.setCount(count);
        List<Area> areas = iAreaService.getAreaList();
        areaResultList.setDataList(areas);
        return ResultJson.createBySuccess(areaResultList);
    }

    @ApiOperation(value = "王斑: 根据id获取区域数据", notes = "")
    @GetMapping(value = "info")
    public ResultJson<Area> getAreaById(Integer areaId) {
        if (areaId == null) {
            return ResultJson.createByErrorMsg("参数为空");
        }
        Area area = iAreaService.getAreaById(areaId);
        return ResultJson.createBySuccess(area);
    }

    @ApiOperation(value = "王斑: 增加区域", notes = "")
    @PostMapping(value = "add")
    public ResultJson<String> addArea(AreaDTO area) {
        if (ObjectUtils.isEmpty(area)) {
            return ResultJson.createByErrorMsg("参数为空");
        }
        return iAreaService.addArea(area) ? ResultJson.createBySuccess("添加成功") : ResultJson.createByErrorMsg("添加失败");
    }

    @ApiOperation(value = "王斑: 修改区域", notes = "")
    @PostMapping(value = "modifyArea")
    public ResultJson<String> modifyArea(Area area) {
        if (area == null || area.getAreaId() == null) {
            return ResultJson.createByErrorMsg("参数为空");
        }
        return iAreaService.modifyArea(area) ? ResultJson.createBySuccess("修改成功") : ResultJson.createByErrorMsg("修改失败");
    }

    @ApiOperation(value = "王斑: 删除区域", notes = "")
    @PostMapping(value = "delete")
    public ResultJson<String> deleteAreaById(Integer areaId) {
        if (areaId == null) {
            return ResultJson.createByErrorMsg("参数为空");
        }
        return iAreaService.deleteAreaById(areaId) ? ResultJson.createBySuccess("删除成功") : ResultJson.createByErrorMsg("删除失败");

    }
}
