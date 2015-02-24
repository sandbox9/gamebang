(function(){
    "use strict";

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

})();