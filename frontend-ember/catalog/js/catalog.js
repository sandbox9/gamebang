(function(){
    "use strict";

    window.App = Ember.Application.create();
    /* model + REST 일 때 prefix 주기 위해 사용 */
    App.ApplicationAdapter = DS.RESTAdapter.extend({
        host: 'http://localhost:10001',
        namespace: 'catalog'
    });

    App.Product = DS.Model.extend({
        productId: DS.attr('string'),
        productName: DS.attr('string'),
        salePrice: DS.attr('number'),
        selectedSku: DS.attr('string'),
        selectedQuantity: DS.attr('number'),
        skuList: DS.hasMany('skuList')
    });

    App.SkuList = DS.Model.extend({
        product: DS.belongsTo('product'),
        skuId: DS.attr('string'),
        displayName: DS.attr('string'),
        addPrice: DS.attr('number'),
        stock: DS.attr('number')
    });

    App.ProductSerializer = DS.RESTSerializer.extend(DS.EmbeddedRecordsMixin, {
        primaryKey: 'productId',
        attrs: {
            skuList: {embedded: 'always'}
        }
    });

    App.SkuListSerializer = DS.RESTSerializer.extend({
        primaryKey: 'skuId'
    });

    App.Router.map(function() {
        this.resource('theme', {path: "/theme"});
        this.resource('category', {path: "/category"});
        this.resource('season', {path: "/season"});
        this.resource('new', {path: "/new"});
        this.resource('product', {path: "/product/:productId"})
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

    App.ProductRoute = Ember.Route.extend({
        model: function(params) {
            //return Ember.$.getJSON('http://localhost:10001/catalog/product/' + params.productId);
            var product = this.store.find('product', params.productId);
            console.log("product: " + product);
            return product;
        }
        ,setupController : function(controller, model){
            controller.set("model", model);
        }
    });

    App.ProductController = Ember.ObjectController.extend({
        actions: {
            addToCart: function(model) {
                console.log(">>submit model1: " + model);
                console.log("selected sku: " + model.get('selectedSku'));
                model.save();
            }
        },
        quantityWithOneToTen: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    });
})();