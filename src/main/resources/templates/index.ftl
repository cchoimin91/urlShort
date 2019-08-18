<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>kakaoPay short Url</title>
    <style>
        .inputUrl {
            width: 30%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box
        }

        .create{
                width: 100px;
                background-color: #ffdf00;
                border: none;
                color: #fff;
                padding: 15px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 4px;
                cursor: pointer;
                color: black;
        }

        .clear{
            width: 100px;
            background-color: black;
            border: none;
            color: #fff;
            padding: 15px 0;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px;
            cursor: pointer;
            color: black;
            color: white;
        }
    </style>

</head>
<body>
    <div align="center">
        <div style="border: solid 1px #ffdf00;width: 100%;height: 142px;font-size: 80px;background: #ffdf00;">
            SHORTENING SERVICE
        </div>


        <div>
            <input type="text" id="inputUrl" class="inputUrl"name="inputUrl"/>
            <button class="button create" id="createBtn">입력</button>
            <button class="button clear" id="clearBtn">초기화</button>
        </div>

        <div id="result">

        </div>
    </div>

</body>
</html>

<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/urlshort.js"></script>
