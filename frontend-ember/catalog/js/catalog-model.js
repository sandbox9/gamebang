(function(){
    "use strict";

    App.Product = DS.Model.extend({
        productId: DS.attr('string'),
        productName: DS.attr('string'),
        salePrice: DS.attr('number'),
        selectedSku: DS.attr('string'),
        selectedQuantity: DS.attr('number'),
        imageList: DS.hasMany('productImageList'),
        skuList: DS.hasMany('skuList')
    });

    App.ProductImageList = DS.Model.extend({
        imageUrl: DS.attr('string'),
        displayOrder: DS.attr('number')
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
            skuList: {embedded: 'always'},
            imageList: {embedded: 'always'}
        }
    });

    App.SkuListSerializer = DS.RESTSerializer.extend({
        primaryKey: 'skuId'
    });

    App.ProductImageListSerializer = DS.RESTSerializer.extend({
        primaryKey: 'displayOrder'
    });

})();