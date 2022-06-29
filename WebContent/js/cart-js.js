

const price = document.getElementById("item_price");
const count = document.getElementsByName("count")[0];
const total_price = document.getElementsByName("total_price")[0];

count.onchange = function(){
	let product = price.value * count.value;
	total_price.value = product;
};

