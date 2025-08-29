#/usr/bin/bash

# This scripts sets up the environment for UCA batch by installing the necessary softwares

packages=(checkstyle default-jdk cpplint build-essential vim)

# Check if user has sudo privileges
[[ $(sudo whoami) -ne "root" ]] && { echo "User ${USER} does not have necessary privileges." ; exit 1 ; }

######################### Install packages #########################
# Update packages
sudo apt-get update

# Install packages
for package in ${packages[@]}:
do
  echo ${package}
  # Check if package is installed, if not install it
  dpkg -s 1>/dev/null 2>&1 || sudo apt-get install -y ${package}
done
######################### Install packages #########################

######################### Setup Vim ################################
rm -f ~/.vimrc
echo "set tabstop=2" >> ~/.vimrc
echo "set shiftwidth=2" >> ~/.vimrc
echo "set expandtab" >> ~/.vimrc
echo "set number" >> ~/.vimrc
echo "set autoindent" >> ~/.vimrc
echo "set smartindent" >> ~/.vimrc
echo "set smarttab" >> ~/.vimrc
source ~/.vimrc
######################### Setup Vim ################################

echo "Setup complete!":
