const TextButton = ({
  label,
  onClick
}) => {
  return (
    <p
      className="text-button"
      onClick={onClick}
    >
      {label}
    </p>
  )
}

export default TextButton;