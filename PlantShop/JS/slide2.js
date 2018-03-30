var slideIndex = 1;
show(slideIndex);
function clickButton(n) {
    show(slideIndex += n);
}
function current(n) {
    show(slideIndex = n);
}
function show(n) {
    var item = document.getElementsByClassName("slider");
    var color = document.getElementsByClassName("colorButton");
    if (n > item.length) {
        slideIndex = 1;
    }
    if (n < 1) {
        slideIndex = item.length;
    }
    for (i = 0; i < item.length; ++i) {
        item[i].style.display = "none";
        color[i].className = color[i].className.replace(" colorButton1", "");

    }
    item[slideIndex - 1].style.display = "block";
    color[slideIndex - 1].className += " colorButton1";
    setTimeout(function() {
        show(slideIndex)
    }, 5000);
    slideIndex += 1;
}