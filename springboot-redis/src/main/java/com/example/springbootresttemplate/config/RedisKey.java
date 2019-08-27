package com.example.springbootresttemplate.config;


/**
 * memcached中使用的前缀
 *
 * @version 2011-11-28
 */
public class RedisKey
{
    public final static String KEY_SPLIT=":";

    // 用于缓存产生的session
    public final static String LOGIN_SESSION_KEY = "str_login_session_key:";

    /**
     * 视频房间 users：注册人数 guests：游客人数 total：总人数 status：是否直播中 rtmp_host：rtmp地址 rtmp_port：rtmp端口 channel_id：所属频道id
     */
    public final static String HROOM = "hroom:";

    /**
     * 房间列表 uid->roomId
     */
    public final static String HROOM_IDS = "hroom_ids";

    /**
     * 设置用户权限（资源）
     */
    public final static String USER_RESOURCE = "user_resource";

    /**
     * rtmp上播地址
     */
    public final static String SRTMP_SERVER = "srtmp_server";

    /**
     * 用户信息
     */
    public final static String HUSER_INFO = "huser_info:";

    /**
     * rtmp下播地址
     */
    public final static String SRTMP_USER = "srtmp_user:";

    /**
     * session
     */
    public final static String SESSION = "session:";

    /**
     * socket信息记录
     */
    public final static String CHANNEL_INFO = "channel_info:";

    /**
     * socket更新时间（秒）
     */
    public final static String CHANNEL_UPDATE = "channel_update";


    /**
     *  礼物信息
     */
    public final static String GIFT_INFO = "hgift_info";


    /**
     *  vip信息
     */
    public final static String VIP_INFO = "hvip_info";

    /**
     *  禁言等级
     */
    public final static String STR_FORBID_LEVEL = "str_forbid_level";

    public final static String ANCHOR_SET = "hanchor_set";

    /**
     *  登录的session
     */
    public static final String LOGIN_SESSIONID_KEY = "str_login_session_id";

    /**
     *  获取在线客服的后台用户id
     */
    public final static String ON_LINE_USER = "str_on_line_user";

    /**
     *  获取后台在线用户的密码
     */
    public final static String ON_LINE_USER_PWD = "honline_user_pwd";

    /**
     *  代充用户信息
     */
    public static final String LOGIN_AGENT_INFO_KEY = "LoginAgentInfoKey";

    /**
     * 获取总后台银行卡列表，因为页面调用频繁，会造成容易柱塞
     */
    public static final String BACK_BANK_LIST = "BackBankLst";

    /**
     * 观看总人数
     */
    public static final String SROOM = "sroom:";

    /**
     * 游戏与房间的对应关系
     */
    public final static String GOOD_ROOM = "sgood:";

    /**
     * vip图片时间
     */
    public final static String HVIP_INFO="hvip_info";

}
