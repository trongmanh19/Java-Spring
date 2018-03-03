$(document).ready(function() {
    /******************************
        BOTTOM SCROLL TOP BUTTON
     ******************************/

    // declare variable
    var scrollTop = $(".scrollTop");
    var srcBrand = $(".brand__img");
    var megaMenu = $(".mega-menu .nav");
    var cartIcon = $(".js-navbar-right");

    $(window).scroll(function() {
        // declare variable
        var topPos = $(this).scrollTop();

        // if user scrolls down - show scroll to top button
        if (topPos > 100) {
            $(scrollTop).css("opacity", "1");
            $(srcBrand).attr("src", "https://canifa.s3.amazonaws.com/media/wysiwyg/info/logo_scroll.jpg");
            $(megaMenu).css("margin", "10px");
            $(cartIcon).css("margin", "10px");

        } else {
            $(scrollTop).css("opacity", "0");
            $(srcBrand).attr("src", "https://canifa.s3.amazonaws.com/media/wysiwyg/info/logo.jpg");
            $(megaMenu).css("margin", "30px");
            $(cartIcon).css("margin", "30px");
        }

    }); // scroll END

    //Click event to scroll to top
    $(scrollTop).click(function() {
        $('html, body').animate({
            scrollTop: 0
        }, 800);
        return false;

    }); // click() scroll top EMD

}); // ready() END