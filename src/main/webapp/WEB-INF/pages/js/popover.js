$(document).ready(function() {
	
	$("#name").focus(function() {
		$(this).popover({
				trigger:"focus",
				container:"body",
				toggle:"popover",
				placement:"right",
				content:"Поле, обов'язкове для заповнення. " +
						"Ім'я може містити великі та малі букви англійського алфавіту, а також цифри. " +
						"Клькість символів: від 2 до 20."
		});
		$(this).popover("show");
	});
	
	$("#name").blur(function() {
		$(this).popover("hide");
	});
	
	$("#email").focus(function() {
		$(this).popover({
				trigger:"focus",
				container:"body",
				toggle:"popover",
				placement:"right",
				content:"Поле, обов'язкове для заповнення. " +
						"Email може містити великі та малі букви англійського алфавіту, цифри, " +
						" та символи ._%+-@  Максимальна кількість символів: 30."
		});
		$(this).popover("show");
	});
	
	$("#email").blur(function() {
		$(this).popover("hide");
	});
	
	$("#password").focus(function() {
		$(this).popover({
				trigger:"focus",
				container:"body",
				toggle:"popover",
				placement:"right",
				content:"Поле, обов'язкове для заповнення. " +
						"Пароль може містити великі та малі букви англійського алфавіту, цифри, " +
						" та символи ._%+-  Клькість символів: від 4 до 15."
		});
		$(this).popover("show");
	});
	
	$("#password").blur(function() {
		$(this).popover("hide");
	});
	
	$("#confirmPassword").focus(function() {
		$(this).popover({
				trigger:"focus",
				container:"body",
				toggle:"popover",
				placement:"right",
				content:"Поле, обов'язкове для заповнення. " +
						"Повторно введіль ваш пароль."
		});
		$(this).popover("show");
	});
	
	$("#confirmPassword").blur(function() {
		$(this).popover("hide");
	});
	
});