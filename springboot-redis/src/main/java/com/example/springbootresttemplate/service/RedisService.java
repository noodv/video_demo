package com.example.springbootresttemplate.service;

import com.example.springbootresttemplate.config.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class RedisService
{

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource(name = "hashObjectOperations")
    private HashOperations<String, Object, String> hashOps;
    @Resource(name = "hashStringOperations")
    private HashOperations<String, String, String> hashEntryOps;
    @Resource
    private SetOperations<String, String> setOps;
    // 对redis字符串类型数据操作
    @Resource
    private ValueOperations<String, String> valueOps;
    @Resource
    private ListOperations<String, String> listOps;
    @Resource
    private ZSetOperations<String, String> zsetOps;

    public String getLoginSessionKey(String comId, String uid) {
        return valueOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.LOGIN_SESSION_KEY + uid);
    }

    /**
     * 获取所有主播uid
     */
    public Map<String, String> getRoomIds(String comId) {
        return hashEntryOps.entries(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM_IDS);
    }

    /**
     * 设置主播uid
     */
    public void setRoomIds(String comId, String toomId, String value) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM_IDS, toomId, value);
    }

    public List<String> getBackBanks(String comId, Long start, Long end) {
        List<String> list = redisTemplate.opsForList().range(comId + RedisKey.KEY_SPLIT + RedisKey.BACK_BANK_LIST, start, end);
        return list;
    }

    /**
     * 设置用户权限
     */
    public void setUserResource(String comId, String userId, String value) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.USER_RESOURCE, userId, value);
    }

    /**
     * 设置用户权限
     */
    public String getUserResource(String comId, String userId) {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.USER_RESOURCE, userId);
    }

    /**
     * 获取rtmp上播地址
     */
    public Set<String> getRtmpServers(String comId) {
        return setOps.members(comId + RedisKey.KEY_SPLIT + RedisKey.SRTMP_SERVER);
    }


    /**
     * 在线客服(后台用户)的id + token 放入 redis中
     *
     * @param uid
     * @param ip
     */
    public void setOnLineUser(String comId, String uid, String ip)
    {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER, uid,ip);
    }

    /**
     * 在线客服(后台用户)的id + pwd 放入 redis中
     *
     * @param comId
     * @param uid
     * @param password
     */
    public void setOnlineUserPwd(String comId, String uid , String password)
    {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER_PWD, uid,password);
    }

    /**
     * 获取在线用户的ip
     *
     * @param comId
     * @param uid
     */
    public String getOnlineUserIp(String comId, String uid)
    {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER, uid);
    }


    /**
     * 获取在线用户的ip
     *
     * @param comId
     * @param uid
     */
    public String getOnlineUserPwd(String comId, String uid)
    {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER_PWD, uid);
    }


    /**
     * 删除所有的在线用户
     * @param uids
     */
    public void removeOnLineUser(String comId, Set<String> uids)
    {
        for (String id : uids)
        {
            hashOps.delete(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER,id);
        }

    }

    /**
     * 获取在线客用户（客服）的所有uid
     *
     * @return
     */
    public Set<Object> getOnLineUserIds(String comId) {
        //从redis左边获取用户的信息
        return hashOps.keys(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER);
    }

    /**
     * 获取在线客服的uid
     *
     * @return
     */
    public String getFirstOnLineUser(String comId) {
        String userStr = valueOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.ON_LINE_USER);
        String uid = userStr.substring(0, userStr.indexOf(","));
        userStr = userStr.substring(userStr.indexOf(",")) + "," + uid;
        return uid;
    }

    /**
     * 房间是否存在
     */
    public boolean hasRoom(String comId, String roomId) {
        return redisTemplate.hasKey(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId);
    }

    /**
     * 获取房间配置信息
     */
    public Map<String, String> getRoomConfig(String comId, String roomId) {
        return hashEntryOps.entries(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId);
    }

    /**
     * 设置房间属性
     */
    public void setRoomProperty(String comId, String roomId, String hashKey, String value) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId, hashKey, value);
    }

    /**
     * 增加房间属性值
     */
    public void incrRoomProperty(String comId, String roomId, String hashKey, long value) {
        hashOps.increment(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId, hashKey, value);
    }

    /**
     * 设置房间属性
     */
    public String getRoomProperty(String comId, String roomId, String hashKey) {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId, hashKey);
    }

    public String getUserProperty(String comId, String uid, String hashKey) {
        String key = comId + RedisKey.KEY_SPLIT + RedisKey.HUSER_INFO + uid;
        return hashEntryOps.get(key, hashKey);
    }

    public void setUserProperty(String comId, String uid, String hashKey, String hashValue) {
        String key = comId + RedisKey.KEY_SPLIT + RedisKey.HUSER_INFO + uid;
        hashEntryOps.put(key, hashKey, hashValue);
    }

    public void setUserAmount(String comId, String uid, String hashKey, long hashValue) {
        String key = comId + RedisKey.KEY_SPLIT + RedisKey.HUSER_INFO + uid;
        hashEntryOps.increment(key, hashKey, hashValue);
    }

    /**
     * 更新登录用户session
     */
    public void setLoginSessionIDKey(String comId, String sessionID, String user) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.LOGIN_SESSIONID_KEY, sessionID, user);
    }

    /**
     * 获取登录用户session
     */
    public Object getLoginSessionIDKey(String comId, String sessionID) {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.LOGIN_SESSIONID_KEY, sessionID);
    }

    /**
     * 获取rtmp用户下播地址
     */
    public Set<String> getUserRtmpRoom(String comId, String rtmp) {
        return setOps.members(comId + RedisKey.KEY_SPLIT + RedisKey.SRTMP_USER + rtmp);
    }

    /**
     * 设置礼物的缓存前缀
     */
    public void setGiftInfo(String comId, String giftId, String value) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.GIFT_INFO, giftId, value);
    }

    /**
     * 获取礼物信息
     */
    public String getGiftInfo(String comId, String giftId) {
        return hashOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.GIFT_INFO, giftId);
    }

    /**
     * 设置禁言等级
     *
     * @param value
     */
    public void setForbidLevel(String comId, String value) {
        valueOps.set(comId + RedisKey.KEY_SPLIT + RedisKey.STR_FORBID_LEVEL, value);
    }

    public void setAnchorSet(String comId, String key, String value) {
        hashEntryOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.ANCHOR_SET, key, value);
    }

    /**
     * 设置代充信息
     *
     * @param agencyId
     * @param value
     */
    public void setLoginAgencyInfo(String comId, String agencyId, String value) {
        hashOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.LOGIN_AGENT_INFO_KEY, agencyId, value);
    }

    public String getForbidLevel(String comId) {
        return valueOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.STR_FORBID_LEVEL);
    }

    public void putStringValue(String comId, String key, String value) throws Exception {
        valueOps.set(comId + RedisKey.KEY_SPLIT + key, value);
    }

    public String getStringValue(String comId, String key) throws Exception {
        return valueOps.get(comId + RedisKey.KEY_SPLIT + key);
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 功能描述:
     *
     * @title: get    读取缓存
     * @param: [key]
     * @return: java.lang.String
     * @auther: yuyun
     * @date: 2019/3/18 20:02
     */
    public Object get(String comId, final String key) {
        Object result = null;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            result = operations.get(comId + RedisKey.KEY_SPLIT + key);
            return result;
        } finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 功能描述:
     *
     * @title: remove   批量删除对应的value
     * @param: [keys]
     * @return: void
     * @auther: yuyun
     * @date: 2019/3/18 20:08
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 移除总中奖金额
     * @param comId
     * @param roomId
     * @param hashKey
     */
    public void delRoomProperty(String comId, String roomId, String hashKey) {
        HashOperations<String, String, String> hashEntryOps = redisTemplate.opsForHash();
        hashEntryOps.delete(comId + RedisKey.KEY_SPLIT + RedisKey.HROOM + roomId, hashKey);
    }

    /**
     * 获取观看人数
     * @param comId
     * @param roomId
     * @return
     */
    public Long getRoomViewerSize(String comId, String roomId) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        return setOps.size(comId + RedisKey.KEY_SPLIT + RedisKey.SROOM + roomId);
    }

    /**
     * 移除游戏房间
     *
     * @param goodId
     * @param roomId
     */
    public void delGoodRoom(String comId, String goodId, String roomId) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        setOps.remove(comId + RedisKey.KEY_SPLIT + RedisKey.GOOD_ROOM + goodId, roomId);
    }

    public void deleteRoomViewer(String comId, String roomId) {
        redisTemplate.delete(comId + RedisKey.KEY_SPLIT + RedisKey.SROOM + roomId);
    }

    /**
     * 设置游戏房间
     *
     * @param goodId
     * @param roomId
     */
    public void setGoodRoom(String comId, String goodId, String roomId) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        setOps.add(comId + RedisKey.KEY_SPLIT + RedisKey.GOOD_ROOM + goodId, roomId);
    }

    public void setVipInfo(String comId ,String hashKey, String hashValue) {
        hashEntryOps.put(comId + RedisKey.KEY_SPLIT + RedisKey.HVIP_INFO, hashKey, hashValue);
    }

    public String getVipInfo(String comId,String hashKey) {
        return hashEntryOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.HVIP_INFO, hashKey);
    }

    public String getAnchorSet(String comId,String key) {
        return hashEntryOps.get(comId + RedisKey.KEY_SPLIT + RedisKey.ANCHOR_SET, key);
    }

    public void delLoginSessionIDKey(String comId, String sessionID) {
        hashOps.delete(comId + RedisKey.KEY_SPLIT + RedisKey.LOGIN_SESSIONID_KEY, sessionID);
    }
}
