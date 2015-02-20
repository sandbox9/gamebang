(function(){
    "use strict";

    /* Template */
    /* 빠르게 구현 목적에서 만들고 차후 Grunt 적용 */

    getTemplate('nav', 'nav');
    getTemplate('theme', 'theme');
    getTemplate('category', 'category');
    getTemplate('productDetail', 'productDetail');

    function getTemplate(templateName, url) {
        $.ajax({
            url: 'http://localhost:63342/legostore/frontend-ember/catalog/template/' + url + '.hbs',
            dataType: 'text',
            success: function (res) {
                console.log(res);
                Ember.TEMPLATES[templateName] = Ember.Handlebars.compile(res);
                //Ember.TEMPLATES['_nav'] = Ember.Handlebars.compile(res);
                //App.NavView = Ember.View.extend({
                //    template: Ember.Handlebars.compile(res)
                //});
            }
        });
    }

})();