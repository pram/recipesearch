import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class SearchBar extends Component {
  render() {
    return (
      <form>
        <input type="text" placeholder="Search..." value={this.props.filterText} />
        <p>
          <input type="checkbox" checked={this.props.inStockOnly} />
          {' '}
          Only show products in stock
        </p>
      </form>
    );
  }
}

export default SearchBar;
