import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class SearchBar extends Component {

  constructor(props) {
    super();
    //console.log(props);
    x = props;
  }

  PropTypes = {
    filterText: PropTypes.string,
    inStockOnly: PropTypes.bool,
    onUserInput: PropTypes.func
  }

  static defaultProps = {
    onUserInput: () => {}
  }

  /*onUserInput(event) {
    this.props.onUserInput(
      this.refs.filterTextInput.value,
      this.refs.inStockOnlyInput.checked
    );
  }*/

  handleChange(x,y,z) {
    x(y.value,z.isChecked);
  }

  render() {

    /*const { onUserInput } = this.state;*/

    return (
      <form>
        <input
          type="text"
          placeholder="Search..."
          value={this.props.filterText}
          ref="filterTextInput"
          onChange={() => this.handleChange(this.props.onUserInput, this.props.filterText, this.props.inStockOnly)}
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
