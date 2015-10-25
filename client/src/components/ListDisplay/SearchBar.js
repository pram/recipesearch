import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class SearchBar extends Component {

  static propTypes = {
    //onUserInput: PropTypes.object,
  };

  handleChange() {
    console.log(this.props);
  };


  render() {
    const { to, query, ...props } = this.props;
    return (
      <form>
        <input
          type="text"
          placeholder="Search..."
          value={this.props.filterText}
          ref="filterTextInput"
          onChange={this.handleChange}
          />

        <p>
          <input
            type="checkbox"
            checked={this.props.inStockOnly}
            ref="inStockOnlyInput"
            onChange={this.handleChange}
            />
          {' '}
          Only show products in stock
        </p>
      </form>
    );
  }
}

export default SearchBar;
