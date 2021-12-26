var vm = new Vue({
	el : "#app",
	data:{
		items : "",
		isSelectAll : false,
		totalPrice : 0,
		modalShow : false,
		item : ""
	},
	mounted: function () {
	  this.$nextTick(function () {
		this.getInfor();
	  })
	},
	filters:{
		formatMoney:function(value){
			return "￥ "+value.toFixed(2);
		}
	},
	methods:{
		getInfor:function(){
			axios.get("/cartList")
			.then(function(result){
				vm.items = result.data.data.list;
				console.log(this.items)
			})
		},
		sub:function(dom){
			dom.count--;
			if(dom.count<1){
				dom.count = 1;
			}
			this.totalPriceC
		},
		add:function(item){
			item.count ++;
			this.totalPriceC
		},
		select:function(item){
			if(typeof item.isSelect=='undefined'){
				vm.$set( item, 'isSelect' , true );
			} else {
				item.isSelect = !item.isSelect;
			}
			this.totalPriceC;
		},
		selectAll:function(flag){
			if(flag){
				this.isSelectAll = true;
			} else{
				this.isSelectAll = flag;
			}
			
			this.items.forEach((item,index)=>{
				if(typeof item.isSelect=='undefined'){
					vm.$set( item, 'isSelect' , this.isSelectAll );
				} else {
					item.isSelect = this.isSelectAll;
				}
			})
			this.totalPriceC;
		},
		deleteItem:function(item){
			this.modalShow = true;
			this.item = item;
		},
		deleConfirm:function(){
			var index = this.items.indexOf(this.item);
			if(index!=-1){
				this.items.splice(index,1);
			}
			this.modalShow = false;
		}
	},
	computed:{
		totalPriceC:function(){
			this.totalPrice = 0;
			this.items.forEach((item,index)=>{
				if(item.isSelect==true){
					this.totalPrice += item.price*item.count
				}
			})
			return this.totalPrice;
		}
	}
})