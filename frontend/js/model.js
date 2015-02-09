Categories.MainCategory = DS.Model.extend({
    title: DS.attr('string')
});

Categories.MainCategory.FIXTURES = [
    {
        id: 1,
        title: '테마별'
    },
    {
        id: 2,
        title: '종류별'
    },
    {
        id: 3,
        title: '나이별'
    },
    {
        id: 4,
        title: '시즌제품'
    },
    {
        id: 5,
        title: '신제품'
    }
];