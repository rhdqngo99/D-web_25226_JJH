const OutlineInput = ({
    value,
    placeholder,
    onChange
  }) => {
    return (
      <input
        type="text"
        className="outline-input"
        placeholder={placeholder}
        value={value}
        onChange={onChange}
      />
    )
  }
  
  export default OutlineInput;