function initiateClock() {
    var today = new Date();
    var hours = today.getHours();
    var minutes = today.getMinutes();
    var seconds = today.getSeconds();
    $("#clock").html( hours + ":" + minutes + ":" + seconds);
    var t = setTimeout(initiateClock, 500);
}

function centerFloatingPanel() {
    $("#floatingPanel").css({
        position: "absolute",
        left: ($(window).width() - $("#floatingPanel").outerWidth()) / 2,
        top: ($(window).height() - $("#floatingPanel").outerHeight()) / 2
    });
}

$(function() {
    console.log("Initializing the draggable property for the floating panel");
    $("#floatingPanel").draggable({ containment: "parent"});
    
    $(".positionRadio").change(function () {
        if(this.value == "centre") {
            if($("#floatingPanel").hasClass("lowerRightPosition")) {
                $("#floatingPanel").removeClass("lowerRightPosition");
            }
            centerFloatingPanel();
        } else if (this.value == "lowerRight") {
            if($("#floatingPanel").attr("style")) {
                $("#floatingPanel").removeAttr("style");
            }
            $("#floatingPanel").addClass("lowerRightPosition");
        }
    });
    
    $(document).on('keypress', function(e){
        if(e.keyCode === 27) {
            console.log("Escape pressed. Hiding the floating panel");
            $("#floatingPanel").hide();
        } else if(e.keyCode === 13) {
            console.log("Enter pressed. Showing the floating panel");
            $("#floatingPanel").show();
        }
    });
    
    $(window).resize(centerFloatingPanel);
    
});