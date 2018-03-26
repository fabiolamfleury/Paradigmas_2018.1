module File where
import System.IO (readFile)
import System.Directory

readingFile :: IO String
readingFile = do
                putStrLn "Digite o nome do arquivo que será lido"
                fileName <- getLine
                readFile fileName

currentPath :: IO FilePath
currentPath = getCurrentDirectory

writingFile :: String -> IO ()
writingFile content = do
                        putStrLn "Digite o nome do arquivo de saida"
                        fileName <- getLine
                        writeFile fileName content
