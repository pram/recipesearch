import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';
import SearchBar from './SearchBar';
import ProductTable from './ProductTable';

@withStyles(styles)
class FilterableProductTable extends Component {
  /*getInitialState() {
    return {
      filterText: '',
      inStockOnly: false
    };
  };*/
  constructor() {
    super();
    this.state = {
      filterText: '',
      inStockOnly: false
    };
  }

  render() {
    return (
      <div>
        <SearchBar
          filterText={this.state.filterText}
          inStockOnly={this.state.inStockOnly}
          />
        <ProductTable
          products={this.props.products}
          filterText={this.state.filterText}
          inStockOnly={this.state.inStockOnly}
          />
      </div>
    );
  }
}

export default FilterableProductTable;
