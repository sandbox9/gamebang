(function(){
    "use strict";

    window.App = Ember.Application.create();
    /* model + REST 일 때 prefix 주기 위해 사용
    App.ApplicationAdapter = DS.RESTAdapter.extend({
        host: 'http://localhost:10001',
        namespace: 'catalog'
    });
    */

    App.Theme = DS.Model.extend({
        screenName: DS.attr('string'),
        productList: DS.hasMany('productList')
    });

    App.ProductList = DS.Model.extend({
        productId: DS.attr('string'),
        productName: DS.attr('string'),
        productPrice: DS.attr('integer')
    });

    App.Router.map(function() {
        this.resource('theme', {path: "/theme"});
        this.resource('category', {path: "/category"});
        this.resource('season', {path: "/season"});
        this.resource('new', {path: "/new"});
        this.resource('productDetail', {path: "/productDetail/:productId"})
    });

    App.IndexRoute = Ember.Route.extend({
        redirect: function() {
            this.transitionTo('theme');
        }
    });

    App.ThemeRoute = Ember.Route.extend({
        model: function() {
            //TODO JSON과 데이터 모델 연계
            //return this.store.find('theme');
            return Ember.$.getJSON('http://localhost:10001/catalog/theme');
        }
    });

    App.ProductDetailRoute = Ember.Route.extend({
        /*
        model: function(params) {
            return {
                productId: params.productId,
                productName: '레고1',
                productPrice: 1000
            };
        }*/
        model: function(params) {
            return Ember.$.getJSON('http://localhost:10001/catalog/product/' + params.productId);
        }
    });

})();