import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';
import SearchBar from './SearchBar';
import ProductTable from './ProductTable';

@withStyles(styles)
class FilterableProductTable extends Component{
  render() {
    return (
      <div>
        <SearchBar />
        <ProductTable products={this.props.products} />
      </div>
    );
  }
}

export default FilterableProductTable;
