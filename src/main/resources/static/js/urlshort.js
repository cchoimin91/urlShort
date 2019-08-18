
$(document).ready(function() {
    urlShort.init();
});

var urlShort = {
	init : function() {
        urlShort.inputInit();
        urlShort.event();
	},

    event : function() {
        $(".button").on("click", function () {
            var id = $(this).attr('id');
            console.log(id);
            switch(id){
                case 'createBtn':
                    urlShort.createUrlShort();
                    break;
                case 'clearBtn':
                    urlShort.inputInit();
                    break;
            }
        });
    },

    createUrlShort : function () {

	    var sendData = {
            'originUrl' :  $('#inputUrl').val()
        }

        $.ajax({
            url : '/createUrlShort',
            data :JSON.stringify(sendData),
            type : 'POST',
            dataType : "json",
            contentType: 'application/json; charset=utf-8',
            success : function(data){
                    $('#result').empty();
                    var dataText ='입력 URL : ' + data.originUrl + '<br> 변환된 URL : '+ data.shortUrl+'';
                    $('#result').append(dataText);
            },
            error : function (data) {
                $('#result').empty();
                var errorText = 'errorCode: '+data.responseJSON.code + '<br>에러타입: '+ data.responseJSON.description + '<br>에러세부내용: '+ data.responseJSON.detail+'';
                $('#result').append(errorText);
            }
        })

	 },

    inputInit : function () {
        $("#inputUrl").val('');
        $('#result').empty();
    }
};
