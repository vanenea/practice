Vue.component('footer-nav',{
	template:'<div class="bottom-nav">\
        <ul>\
            <li :class="{\'active\': activeClass === \'index\'}"><a href="index.html"><i class="icon-home"></i><div>有赞</div></a></li>\
            <li :class="{\'active\': activeClass === \'category\'}"><a href="category.html"><i class="icon-category"></i><div>分类</div></a></li>\
            <li :class="{\'active\': activeClass === \'default\' }"><a href="cart.html"><i class="icon-cart"></i><div>购物车</div></a></li>\
            <li :class="{\'active\': activeClass === \'default\' }"><a href="member.html"><i class="icon-user"></i><div>我</div></a></li>\
        </ul>\
    </div>'
});