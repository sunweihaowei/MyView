package com.example.carousel;

/**
 *
 * 创建人：sunweihao
 * 创建时间：2020/5/7 0011  11:27
 */
public class UrlUtils {
    public static String createHomePagerUrl(int materialId,int page){
        ///discovery/{materialId}/{page}
        return "discovery"+"/"+materialId+"/"+page;
    }

    public static String getCoverPath(String pict_url) {
        return "https:"+pict_url;
    }
    //http://120.24.59.228/yuyinbao/nothing/jsons/album_item_38.json?tdsourcetag=s_pctim_aiomsg
    public static String createVoiceTailUrl(int page){//尾部页
        ///discovery/{materialId}/{page}
        return "album_item_"+page+".json?tdsourcetag=s_pctim_aiomsg";
    }
    //得到图片url
    public static String getImgUrl(int pager){
        return "http://120.24.59.228/yuyinbao/nothing/imgs/author/"+pager+".jpg?tdsourcetag=s_pctim_aiomsg";
    }
}
