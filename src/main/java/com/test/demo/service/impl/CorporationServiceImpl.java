package com.test.demo.service.impl;

import com.test.demo.mapper.CorporationMapper;
import com.test.demo.po.Corporation;
import com.test.demo.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 丁红玉 on 2017/3/11.
 */
@Service
public class CorporationServiceImpl implements CorporationService {
    @Autowired
    CorporationMapper corporationMapper;
    @Override
    public int insertCorporation(Corporation corporation) throws Exception {
        return corporationMapper.insert(corporation);
    }

    @Override
    public Corporation selectCorpByName(Corporation corporation) throws Exception {
        return corporationMapper.selectCorpByName(corporation);
    }

    @Override
    public List<Corporation> getAllCorp() throws Exception {
        return corporationMapper.getAllCorp();
    }

    @Override
    public Corporation selectCorpByLeaderName(String leaderName) throws Exception {
        return corporationMapper.selectCorpByLeaderName(leaderName);
    }
}
