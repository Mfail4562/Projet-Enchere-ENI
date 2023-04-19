function onChange() {
  const password = document.querySelector('input[name=nouveauMotDePasse]');
  const confirm = document.querySelector('input[name=nouveauMotDePasseConfirme]');
  if (confirm.value === password.value) {
    confirm.setCustomValidity('');
  } else {
    confirm.setCustomValidity('Les mots de passes ne sont pas exactes');
  }
}