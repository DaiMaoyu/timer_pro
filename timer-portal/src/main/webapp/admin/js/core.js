let core = {
    //限流工具类
    throttle: function (method, args, context) {
        clearTimeout(method.tId);
        method.tId = setTimeout(function () {
            method.call(args, context);
        }, 200)

    },
    http: function (option) {
        console.log(this.cancel);
        this.cancel && this.cancel.abort();
        let opt = {load: true}, loadHandler, options = {
            url: "",
            method: "post",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            beforeSend: function () {
                this.load && (loadHandler = LayUtil.layer.init(function (inner, layer) {
                    // inner.loading(0, {shade: 0.1})
                }))
            },
            success: function (res) {
                if (res.restCode === CONSTANT.HTTP.SUCCESS) {
                    loadHandler.closeLoading();
                }
            }

        };
        Object.assign(opt, options, option);
        this.cancel = $.ajax(opt);
    }
};

const CONSTANT = {
    HTTP: {
        SUCCESS: 200,
        ERROR: 500
    }
};


// layui工具类
function LayUtil() {
    this.run = function () {

    }
}


LayUtil.prototype = {
    construct: LayUtil,
    //弹窗
    layer: (function (LayUtil) {
        function Inner() {

        }

        Inner.prototype = {
            construct: Inner,
            init: function (callback) {
                let that = this;
                layui.use('layer', function () {
                    that.layer = layui.layer;
                    if (callback instanceof Function) {
                        callback(that, that.layer);
                    }
                })
                return this;
            },
            //显示loading加载
            loading: function (config = {}) {
                console.log(config)

                this.layer.load(config);
            },
            closeLoading: function () {
                this.layer.closeAll('loading');
            }
        }
        LayUtil.layer = new Inner();
    })(LayUtil)


}
