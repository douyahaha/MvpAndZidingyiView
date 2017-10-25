package com.douya.exercise.bean;

import java.util.List;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class MoreBean {

    /**
     * date : 20171024
     * stories : [{"images":["https://pic1.zhimg.com/v2-c8beb82223f0c473ccd9c9ea7d6899d8.jpg"],"type":0,"id":9643838,"ga_prefix":"102422","title":"小事 · 你也有过这种失望"},{"title":"因为这件事，我被骂的很惨","ga_prefix":"102421","images":["https://pic4.zhimg.com/v2-d86cd3e064bf427d578aa456a4f47553.jpg"],"multipic":true,"type":0,"id":9653640},{"images":["https://pic2.zhimg.com/v2-4666c773e9197fa52abf9576f1e66785.jpg"],"type":0,"id":9653464,"ga_prefix":"102420","title":"每天都想看透自己，久而久之，终于看不透了"},{"images":["https://pic1.zhimg.com/v2-8dcf7d6c5ea9217564dfde8834f8de5c.jpg"],"type":0,"id":9653770,"ga_prefix":"102419","title":"对我来说，《英雄联盟》全球总决赛就是最好的体育赛事"},{"images":["https://pic4.zhimg.com/v2-3a6205444f2bf86428b1abf2f110588f.jpg"],"type":0,"id":9653549,"ga_prefix":"102418","title":"又是量杯又是秤的，做甜点，原料用量干嘛要那么精确？"},{"images":["https://pic4.zhimg.com/v2-ee740f35e247150da0c23b26720c543f.jpg"],"type":0,"id":9653741,"ga_prefix":"102417","title":"情侣因未与房东协商好退租押金，结果在出租屋放满死鱼引蛆\u2026\u2026"},{"images":["https://pic4.zhimg.com/v2-ef9a3c5c5b3aba6686ba13d3ec4f683b.jpg"],"type":0,"id":9653531,"ga_prefix":"102416","title":"保健品这东西，当饭吃、当药吃，都是错的"},{"images":["https://pic3.zhimg.com/v2-18f014cbb7c9ca1c57de40df96fb4b8e.jpg"],"type":0,"id":9653488,"ga_prefix":"102415","title":"为什么 AI 都打败李世石、柯洁了，还是没法帮我洗裤衩、做饭？"},{"images":["https://pic1.zhimg.com/v2-351a414cc1a6e4e9319c27bf567d18e8.jpg"],"type":0,"id":9653668,"ga_prefix":"102414","title":"印度送餐产业：多少商学院和大企业想学习，却很难复制"},{"images":["https://pic1.zhimg.com/v2-a86a08c54d44ff54f21ae7e108a11d28.jpg"],"type":0,"id":9653602,"ga_prefix":"102413","title":"「女性读研大多是混个文凭准备就业」，不知不觉就被统计歧视了"},{"images":["https://pic3.zhimg.com/v2-df62676146a39c0e35b583735f9a7b16.jpg"],"type":0,"id":9652899,"ga_prefix":"102412","title":"大误 · Siri 还有几个隐藏技能"},{"images":["https://pic2.zhimg.com/v2-110681fd6816cb2aecf8b675e42efbb1.jpg"],"type":0,"id":9653611,"ga_prefix":"102411","title":"25% 的进口关税免不了，但特斯拉在华独资建厂或许是最好的结果"},{"images":["https://pic2.zhimg.com/v2-fadc5a56094dd981d770a9f45a0704a5.jpg"],"type":0,"id":9653422,"ga_prefix":"102410","title":"壁纸网站经常见的星空大片，其实只是风光摄影的冰山一角"},{"images":["https://pic4.zhimg.com/v2-5aa1f1a7c72c540d9c93f6bb5f67831f.jpg"],"type":0,"id":9653467,"ga_prefix":"102409","title":"「最坏的脾气，不就应该留给最亲的人吗？」"},{"images":["https://pic3.zhimg.com/v2-6b552d29b6621c791701d3bd40518d92.jpg"],"type":0,"id":9653430,"ga_prefix":"102408","title":"为什么 go 的过去式是 went？"},{"images":["https://pic3.zhimg.com/v2-84980650ae87688b0d0aaae26894c5fe.jpg"],"type":0,"id":9653543,"ga_prefix":"102407","title":"煮饭煮出了工匠精神？仙人摇摇头，「你们又给我加戏」"},{"images":["https://pic2.zhimg.com/v2-6dd444c13909d083bc315bd1a9e8a4ed.jpg"],"type":0,"id":9653580,"ga_prefix":"102407","title":"老板：你不接受 996 上班制？呵呵，你就是吃不了苦"},{"images":["https://pic3.zhimg.com/v2-0de15d47477ce02f223b83ffd325d51e.jpg"],"type":0,"id":9653364,"ga_prefix":"102407","title":"某些「教玩家玩游戏」的行为，为什么那么招人恨？"},{"images":["https://pic2.zhimg.com/v2-17606e05073dd06c09788fcc69c50611.jpg"],"type":0,"id":9653347,"ga_prefix":"102406","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-c8beb82223f0c473ccd9c9ea7d6899d8.jpg"]
         * type : 0
         * id : 9643838
         * ga_prefix : 102422
         * title : 小事 · 你也有过这种失望
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
