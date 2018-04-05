module Main where
import System.IO (readFile, hClose)
import Control.Exception
import System.IO.Error
import Data.Function
import System.Console.ANSI
import Huffman
import File

-- Main menu that let user choose between compressing and decompressing files
main :: IO ()
main = do clearScreen
          putStrLn "============= Menu Principal Huffman =============";
            putStrLn "\t1 - Quero comprimir meu arquivo";
            putStrLn "\t2 - Quero descomprimir meu arquivo";
            putStrLn "\t3 - Quero sair do programa";
            opcao <- getLine;
            case opcao of
                 "1" -> encode;
                 "2" -> decode;
                 otherwise -> print "Tchau!"

 -- User chooses file to be compressed
encode :: IO ()
encode = do
            {catch (tryRead) exception;}
            where
                  tryRead = do
                    clearScreen
                    putStrLn "============= Codificar Arquivo ============="
                    putStrLn "Digite o nome do arquivo";
                    fileName <- getLine
                    file <- readFile fileName
                    let list = buildTree (sortingList (elementFrequency file))
                    let lettersCode = findLetterCode list ""
                    putStrLn "Digite o nome do arquivo de saida"
                    fileNameOut <- getLine
                    writeCodeInFile file fileNameOut lettersCode (show(list) ++ "\n")
                    putStrLn "... Aperte enter para retornar ao menu principal"
                    getLine
                    main
                  exception erro = if isDoesNotExistError erro
                          then do
                            putStrLn "Arquivo não encontrado. Digite 1 para escolher outro arquivo ou 2 para voltar ao menu";
                            opcao<-getLine
                            case opcao of
                              "1" -> encode
                              otherwise -> main
                  else ioError erro

decode :: IO()
decode = do
            {catch (tryRead) exception;}
            where
              tryRead = do
                clearScreen
                putStrLn "============= Decodificar Arquivo ============="
                putStrLn "Digite o nome do arquivo a ser decodificado";
                fileName <- getLine
                fileA <- readFile fileName
                let fileLines = lines fileA -- the first line is the tree and the last is the code
                    tree = head fileLines
                    code = last fileLines
                let a = parse tree
                    b = find(code,a,a,"")
                putStrLn "Digite o nome do arquivo de saida"
                fileNameOut <- getLine
                writeDecode fileNameOut b
                putStrLn "... Aperte enter para retornar ao menu principal"
                getLine
                main
              exception erro = if isDoesNotExistError erro
                      then do
                        putStrLn "Arquivo não encontrado. Digite 1 para escolher outro arquivo ou 2 para voltar ao menu";
                        opcao<-getLine
                        case opcao of
                          "1" -> decode
                          otherwise -> main
              else ioError erro
