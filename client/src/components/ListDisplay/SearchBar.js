import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class SearchBar extends Component {

  PropTypes = {
    filterText: PropTypes.string,
    inStockOnly: PropTypes.bool,
    onUserInput: PropTypes.func
  }

  handleChange(e) {
    this.props.onUserInput(
      this.refs.filterTextInput.value,
      this.refs.inStockOnlyInput.checked
    );
  }

  handleSubmit(e) {
    e.preventDefault();
    console.log(e);
    //this.props.onAdd($(e.target).find("input[name=search]").val())
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit.bind(this)}>
        <input
          name="search"
          type="text"
          placeholder="Search..."
          value={this.props.filterText}
          ref="filterTextInput"
          onChange={this.handleChange.bind(this)}
          />

        <p>
          <input
            type="checkbox"
            checked={this.props.inStockOnly}
            ref="inStockOnlyInput"
            onChange={this.handleChange.bind(this)}
            />
          {' '}
          Only show products in stock
        </p>
      </form>
    );
  }
}

export default SearchBar;
