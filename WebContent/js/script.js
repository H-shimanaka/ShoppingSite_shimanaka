
/*生年月日のセレクトタグにオプション追加*/
let birth_year = document.getElementById("birth_year");
let birth_month = document.getElementById("birth_month");
let birth_day = document.getElementById("birth_day");

for(let i = 1920; i <= 2020; i++){
	const option = document.createElement("option");
	option.text = i;
	option.value = i;
	birth_year.appendChild(option);
}

for(let i = 1; i <= 12; i++){
	const option = document.createElement("option");
	option.text = i;
	option.value = i;
	birth_month.appendChild(option);
}

for(let i = 1; i <= 31; i++){
	const option = document.createElement("option");
	option.text = i;
	option.value = i;
	birth_day.appendChild(option);
}