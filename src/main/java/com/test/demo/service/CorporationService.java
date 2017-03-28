package com.test.demo.service;

import com.test.demo.po.Corporation;

import java.util.List;

/**
 * Created by 丁红红 on 2017/3/11.
 */
public interface CorporationService {
    public int insertCorporation(Corporation corporation) throws Exception;

    public Corporation selectCorpByName(Corporation corporation) throws Exception;

    public List<Corporation> getAllCorp() throws Exception;

    public Corporation selectCorpByLeaderName(String leaderName) throws Exception;

}
