import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';
import SearchBar from './SearchBar';
import ProductTable from './ProductTable';

@withStyles(styles)
class FilterableProductTable extends Component {

  constructor(props) {
    super();
    this.state = {
      filterText: '',
      inStockOnly: false,
    };
  }

  handleUserInput(filterText, inStockOnly) {
    this.setState({
      filterText: filterText,
      inStockOnly: inStockOnly
    });
  }

  render() {
    return (
      <div>
        <SearchBar
          filterText={this.state.filterText}
          inStockOnly={this.state.inStockOnly}
          onUserInput={this.handleUserInput.bind(this)}
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
