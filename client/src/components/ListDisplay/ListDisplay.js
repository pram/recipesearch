import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';
import FilterableProductTable from './FilterableProductTable';

var PRODUCTS = [
  {category: 'Cheeese', price: '$49.99', stocked: true, name: 'Football'},
  {category: 'Sporting Goods', price: '$9.99', stocked: true, name: 'Baseball'},
  {category: 'Sporting Goods', price: '$29.99', stocked: false, name: 'Basketball'},
  {category: 'Chicken', price: '$99.99', stocked: true, name: 'iPod Touch'},
  {category: 'Electronics', price: '$399.99', stocked: false, name: 'iPhone 5'},
  {category: 'Big Electronics', price: '$199.99', stocked: true, name: 'Nexus 7'},
];

@withStyles(styles)
class ListDisplay extends Component {
  render() {
    return (
      <FilterableProductTable products={PRODUCTS} />
    );
  }
}
export default ListDisplay;
