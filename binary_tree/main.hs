module Main (main, menu) where

import System.IO
import Control.Monad
import Tree

menu :: BinaryTree -> IO ()
menu tree = do putStrLn "Menu Principal de árvore: ";
               putStrLn "1 - Quero inserir um nó na árvore";
               putStrLn "2 - Quero imprimir a árvore em ordem";
               putStrLn "3 - Quero imprimir a árvore em pós ordem";
               putStrLn "4 - Nenhuma das opcoes";
               opcao <- getLine;
               case opcao of "1" -> putStrLn "Digite o nó que será inserido";
                             "2" -> putStrLn "Aguarde";
                             "3" -> putStrLn "Aguarde";
                             "4" -> menu tree

main :: IO()
main = do menu Null
