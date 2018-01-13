(function($) {
    "use strict";
    $(document).ready(function () { 
        /*===================================================================================*/
        /*  LAZY LOAD IMAGES USING ECHO
        /*===================================================================================*/

        echo.init({
            offset: 100,
            throttle: 250,
            unload: false
        });

        /*===================================================================================*/
        /*  OWL CAROUSEL
        /*===================================================================================*/
        var dragging = true;
        var owlElementID = "#owl-main";

        function fadeInReset() {
            if (!dragging) {
                $(owlElementID + " .caption .fadeIn-1, " + owlElementID + " .caption .fadeIn-2, " + owlElementID + " .caption .fadeIn-3").stop().delay(800).animate({ opacity: 0 }, { duration: 400, easing: "easeInCubic" });
            }
            else {
                $(owlElementID + " .caption .fadeIn-1, " + owlElementID + " .caption .fadeIn-2, " + owlElementID + " .caption .fadeIn-3").css({ opacity: 0 });
            }
        }

        function fadeInDownReset() {
            if (!dragging) {
                $(owlElementID + " .caption .fadeInDown-1, " + owlElementID + " .caption .fadeInDown-2, " + owlElementID + " .caption .fadeInDown-3").stop().delay(800).animate({ opacity: 0, top: "-15px" }, { duration: 400, easing: "easeInCubic" });
            }
            else {
                $(owlElementID + " .caption .fadeInDown-1, " + owlElementID + " .caption .fadeInDown-2, " + owlElementID + " .caption .fadeInDown-3").css({ opacity: 0, top: "-15px" });
            }
        }

        function fadeInUpReset() {
            if (!dragging) {
                $(owlElementID + " .caption .fadeInUp-1, " + owlElementID + " .caption .fadeInUp-2, " + owlElementID + " .caption .fadeInUp-3").stop().delay(800).animate({ opacity: 0, top: "15px" }, { duration: 400, easing: "easeInCubic" });
            }
            else {
                $(owlElementID + " .caption .fadeInUp-1, " + owlElementID + " .caption .fadeInUp-2, " + owlElementID + " .caption .fadeInUp-3").css({ opacity: 0, top: "15px" });
            }
        }

        function fadeInLeftReset() {
            if (!dragging) {
                $(owlElementID + " .caption .fadeInLeft-1, " + owlElementID + " .caption .fadeInLeft-2, " + owlElementID + " .caption .fadeInLeft-3").stop().delay(800).animate({ opacity: 0, left: "15px" }, { duration: 400, easing: "easeInCubic" });
            }
            else {
                $(owlElementID + " .caption .fadeInLeft-1, " + owlElementID + " .caption .fadeInLeft-2, " + owlElementID + " .caption .fadeInLeft-3").css({ opacity: 0, left: "15px" });
            }
        }

        function fadeInRightReset() {
            if (!dragging) {
                $(owlElementID + " .caption .fadeInRight-1, " + owlElementID + " .caption .fadeInRight-2, " + owlElementID + " .caption .fadeInRight-3").stop().delay(800).animate({ opacity: 0, left: "-15px" }, { duration: 400, easing: "easeInCubic" });
            }
            else {
                $(owlElementID + " .caption .fadeInRight-1, " + owlElementID + " .caption .fadeInRight-2, " + owlElementID + " .caption .fadeInRight-3").css({ opacity: 0, left: "-15px" });
            }
        }

        function fadeIn() {
            $(owlElementID + " .active .caption .fadeIn-1").stop().delay(500).animate({ opacity: 1 }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeIn-2").stop().delay(700).animate({ opacity: 1 }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeIn-3").stop().delay(1000).animate({ opacity: 1 }, { duration: 800, easing: "easeOutCubic" });
        }

        function fadeInDown() {
            $(owlElementID + " .active .caption .fadeInDown-1").stop().delay(500).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInDown-2").stop().delay(700).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInDown-3").stop().delay(1000).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
        }

        function fadeInUp() {
            $(owlElementID + " .active .caption .fadeInUp-1").stop().delay(500).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInUp-2").stop().delay(700).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInUp-3").stop().delay(1000).animate({ opacity: 1, top: "0" }, { duration: 800, easing: "easeOutCubic" });
        }

        function fadeInLeft() {
            $(owlElementID + " .active .caption .fadeInLeft-1").stop().delay(500).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInLeft-2").stop().delay(700).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInLeft-3").stop().delay(1000).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
        }

        function fadeInRight() {
            $(owlElementID + " .active .caption .fadeInRight-1").stop().delay(500).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInRight-2").stop().delay(700).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
            $(owlElementID + " .active .caption .fadeInRight-3").stop().delay(1000).animate({ opacity: 1, left: "0" }, { duration: 800, easing: "easeOutCubic" });
        }

        $(owlElementID).owlCarousel({

            autoPlay: 5000,
            stopOnHover: true,
            navigation: true,
            pagination: true,
            singleItem: true,
            addClassActive: true,
            transitionStyle: "fade",
            navigationText: ["<i class='icon fa fa-angle-left'></i>", "<i class='icon fa fa-angle-right'></i>"],

            afterInit: function() {
                fadeIn();
                fadeInDown();
                fadeInUp();
                fadeInLeft();
                fadeInRight();
            },

            beforeMove: function(){
                echo.render();
            },

            afterMove: function() {
                fadeIn();
                fadeInDown();
                fadeInUp();
                fadeInLeft();
                fadeInRight();
            },

            afterUpdate: function() {
                fadeIn();
                fadeInDown();
                fadeInUp();
                fadeInLeft();
                fadeInRight();
            },

            startDragging: function() {
                dragging = true;
            },

            afterAction: function() {
                fadeInReset();
                fadeInDownReset();
                fadeInUpReset();
                fadeInLeftReset();
                fadeInRightReset();
                dragging = false;
            }

        });

        if ($(owlElementID).hasClass("owl-one-item")) {
            $(owlElementID + ".owl-one-item").data('owlCarousel').destroy();
        }

        $(owlElementID + ".owl-one-item").owlCarousel({
            singleItem: true,
            navigation: false,
            pagination: false
        });

        $('#transitionType li a').click(function () {

            $('#transitionType li a').removeClass('active');
            $(this).addClass('active');

            var newValue = $(this).attr('data-transition-type');

            $(owlElementID).data("owlCarousel").transitionTypes(newValue);
            $(owlElementID).trigger("owl.next");

            return false;

        });
        
        /*===================================================================================*/
        /*menu toggle
        /*===================================================================================*/

        $(".menu-toggle-right").click(function(e) {
            // e.preventDefault();
            // $("#wrapper").toggleClass("toggled right");
            // $("body").toggleClass("open-sidebar");
        });

        $(".menu-toggle-left").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled left");
            $("body").toggleClass("open-sidebar");
        });

        $(".st-pusher-after,.remove-icon").click(function(e) {
            $("#wrapper").removeClass("toggled");
            $("#wrapper").removeClass("right");
            $("#wrapper").removeClass("left");
            $("body").toggleClass("open-sidebar");
        });


        /*===================================================================================*/
        /* perfect scroll bar
        /*===================================================================================*/
        $('.scrollbar').perfectScrollbar();

        /*===================================================================================*/
        /* PRICE SLIDER
        /*===================================================================================*/

        $( "#slider-range" ).slider({
            range: true,
            min: 0,
            max: 500,
            values: [ 1, 450 ],
            slide: function( event, ui ) {
                $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
            }
        });
        $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
            " - $" + $( "#slider-range" ).slider( "values", 1 ) );
        
        /*===================================================================================*/
        /*  WOW 
        /*===================================================================================*/

        new WOW().init();

        /*===================================================================================*/
        /*  CUSTOM SELECT
        /*===================================================================================*/

        if( $('.le-select').length > 0){
            $('.le-select select').customSelect({customClass:'le-select-in'});
        }
    }); 
})(jQuery);