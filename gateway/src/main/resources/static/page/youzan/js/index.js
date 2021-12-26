
new Vue({
    el: "#app",
    data: {
        hotList: {
            lists: [],
            loading: false,
            isUserScroll: false,
            isInitSuccess: false,
            isListDone: false,
            pageNum: 0,
        },
        bannerList: null,
        bannerSwiper: {
            options: {
                direction: 'horizontal',
                loop: true,
                pagination: {
                    el: '.index-swiper .swiper-pagination',
                },
                autoplay: true,
            },
            domSelector: ".index-swiper",
        },
    },
//     components: {
//         "foot-nav": footNav,
//         "top-banner": topBanner,
//     },
    methods: {
        loadMore() {
            if (!this.hotList.isUserScroll || !this.hotList.isInitSuccess || this.hotList.isListDone) {return}
            this.hotList.loading = true;
            setTimeout(() => {
                this.getNewData()
            }, 200);
        },
        getNewData(type) {
            
        },
        listenToWindowScroll() {
            window.ontouchmove = (e) => {
                this.hotList.isUserScroll = true
                window.ontouchmove = null
            }

        },
        getBannerImg() {
           
        },
    },
    created() {
        this.getNewData("first")
        this.getBannerImg()
        this.listenToWindowScroll()
    }
   // mixins: [mixin],
})
